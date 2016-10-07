import groovy.json.JsonSlurper
def clone_dependenices()
{
    echo "hello"
    File f1 = new File(".").getAbsolutePath();
    echo "$f1"
    def path = "$WORKSPACE/groovy/dependencies.json" 
    File f = new File( path );
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
