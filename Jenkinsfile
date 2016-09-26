node('local-node') {
        stage 'Clone'
        dir('coral') {
            git branch: 'master', url: 'ssh://gerrit.plumgrid.com:29418/coral'
        }    
        dir('middleware') {
            git branch: 'master', url: 'ssh://gerrit.plumgrid.com:29418/middle-earth'
        }

        stage 'Build'
        sh 'cd middleware; mkdir -p build; cd build; cmake ..; make install;'

        stage 'Pipeline'
        echo " This is pipeline stage"

        stage 'Test Execution'
        sh 'echo "this is test execution"'
}
