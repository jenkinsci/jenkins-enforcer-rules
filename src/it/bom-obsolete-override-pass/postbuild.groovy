// Build should succeed - newer version override is allowed
def buildLog = new File(basedir, 'build.log')
assert buildLog.exists()
assert buildLog.text.contains('io.jenkins.tools.maven.jenkins_enforcer_rules.BanObsoleteDependencyOverrides passed')
return true
