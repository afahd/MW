import groovy.json.JsonSlurper
def clone_dependenices()
{
    echo "hello"
    String path = System.getProperty("user.dir");
    echo "path"
    File f = new File("/dependencies.json");
    def slurper = new JsonSlurper()
    def jsonText = f.getText()
    def json = slurper.parseText( jsonText )
    json.each{
        clone_dependenices(it.project,it.location,it.branch)
        echo "Cloning dependencies for $project "
        git branch: branch, url: location
    }

}
return this;
