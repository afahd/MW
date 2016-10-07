#!groovy

import groovy.json.JsonSlurper

static void clone_dependenices()
{
    File f = new File('dependencies.json')
    def slurper = new JsonSlurper()
    def jsonText = f.getText()
    def json = slurper.parseText( jsonText )
    json.each{
        clone_dependenices(it.project,it.location,it.branch)
        echo "Cloning dependencies for $project "
        git branch: branch, url: location
    }

}

echo "hello"
