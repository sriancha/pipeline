pipeline{
    agent any
    stages {

        stage("build"){
            steps {
                print "hello Good Morning"
                sh "mvn clean package"

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