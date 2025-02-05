#!groovy
import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()

// Buat user admin otomatis
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount("admin", "admin123")
instance.setSecurityRealm(hudsonRealm)

// Berikan hak akses penuh ke admin
def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false)
instance.setAuthorizationStrategy(strategy)

instance.save()

println("✅ Jenkins Setup Completed!")
