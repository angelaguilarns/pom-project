pipeline{
  agent any

  tools{
    maven 'maven3'
  }

  stages{
    stage('Create Selenium Grid'){
      steps{
        sh "docker-compose up"
      }
    }
    stage('Run tests'){
      sh "mvn test -DsuiteXmlFiles=${xmlFile}"
    }
  }

  post{
    always{
      junit 'target/**/*.xml'
      junit 'target/surefire-reports/**/*.xml'
    }
  }

}
