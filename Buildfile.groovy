pipeline{
    agent any
    stages {

        stage("build"){
            steps {
                print "hello Good Morning"

                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'git-auth', url: 'https://github.com/sriancha/GitToday.git']]])
                sh "ls -lart ./*"

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