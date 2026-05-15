def log = new File(basedir, 'build.log').getText('UTF-8')
assert log.contains('io.jenkins.tools.maven.jenkins_enforcer_rules.BanObsoleteDependencyOverrides passed')
return true
