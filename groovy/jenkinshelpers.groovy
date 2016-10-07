import groovy.json.JsonSlurper
def clone_dependenices()
{
    echo "hello"
    URL url = getClass().getResource("dependencies.json");
    File f = new File(url.toURI());
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
