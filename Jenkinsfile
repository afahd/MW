node('local-node') {
    stage 'Clone'
    git("ssh://gerrit.plumgrid.com:29418/builder")
    
    dir('coral') {
        git branch: 'master', url: 'ssh://gerrit.plumgrid.com:29418/coral'
    }
        
    dir('middleware') {
        git branch: 'master', url: 'ssh://gerrit.plumgrid.com:29418/middle-earth'
        sh 'mkdir -p build; cd build; cmake ..; make install;'
    }
        
    stage 'Pipeline'
    withEnv(["WORKSPACE=${pwd()}","JENKINS_BUILDER_SCRIPT_DIR=${pwd()}","JCFG_SKIP_PRE_CLEANUP=1","JCFG_SKIP_POST_CLEANUP=1"]) {
        dir('middleware/build/scripts/devstack')
        {   
            sh '$WORKSPACE/jenkins-middleware-devstack-smoke.sh'
            stage 'lxc devstack cleanup'
            sh 'sudo ./lxc-devstack-cleanup.sh'
            stage 'lxc devstack preinit'
            sh './lxc-devstack-preinit.sh'
            stage 'lxc devstack init'
            sh 'sudo ./lxc-devstack-init.sh -b -c "unstable" -w "${WORKSPACE}"'
        }
    }
    
    stage 'Test Execution'
    sh '${JENKINS_BUILDER_SCRIPT_DIR}/jenkins-middleware-reviewtest.sh'

}
