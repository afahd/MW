import groovy.json.JsonSlurper

static void clone_dependenices(project,location,branch)
{
    println "Cloning dependencies for " + project
    println location
    println branch

    git branch: branch, url: location

}

static void main(String[] args) {

    File f = new File('dependencies.json')
    def slurper = new JsonSlurper()
    def jsonText = f.getText()
    def json = slurper.parseText( jsonText )
    json.each{
        println it.location
        clone_dependenices(it.project,it.location,it.branch)

    }
}