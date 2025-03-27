def buildApp() {
    echo "lets build through scripts ..."
    echo "getting version info through scripts. Version : ${params.NEW_VERSION}"
} 

def deployApp() {
    echo 'deploying the application...'
    echo "environment to deploy: ${params.DEPLOY_ENV} "
} 

return this