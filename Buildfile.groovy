pipeline{
    agent any
    stages {

        stage("build"){
            steps {
                print "hello Good Morning"
                

            }
        
        }
        stage ("upload"){
            steps {
                println "Upload the new file"
            }
        }
        stage ("depoly"){
            steps {
                println "depoly the code"
            }
        }
    }
}