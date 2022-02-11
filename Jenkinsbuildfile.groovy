pipeline{
    agent any
     parameters {

        string (
                name: 'source code branch',
                description: 'Provide the branch name',
                defaultValue: '*/master'
            ) 
      }

    stages {

        stage("Clone- the Repositry"){
            steps {
                print "hello-Good Morning - clone"

                checkout([$class: 'GitSCM', branches: [[name: "${codebranch}"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'git-auth', url: 'https://github.com/sriancha/GitToday.git']]])
                sh """ls -lart ./*"
                echo ${env. JOB-NAME}
                echo ${codebranch}
                echo ${BUILD_NUMBER}

                """

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
                sh "aws s3 cp target/hello-*.war s3://pipelineart/${env. JOB_NAME}/${codebranch}/${BUILD_NUMBER}/ "
            }
        }
    }
}