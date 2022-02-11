pipeline{
    agent any

    stages {

        stage("Clone- the Repositry"){
            steps {
                print "hello-Good Morning - clone"

                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'git-auth', url: 'https://github.com/sriancha/GitToday.git']]])
                sh "ls -lart ./*"

            }
        
        }
        stage ("Build"){
            steps {
        
                println "Upload the new file"
                sh "mvn clean package"
            }
        }
        stage ("upload "){
            steps {
                println "depoly the code"
                sh "ls -lart"
                sh "aws s3 cp target/hello-*.war s3://pipelineart "
            }
        }
    }
}