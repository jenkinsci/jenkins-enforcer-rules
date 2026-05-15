// Build should pass - property override is newer than parent (valid override)
def log = new File(basedir, 'build.log').getText('UTF-8')
assert log.contains('io.jenkins.tools.maven.jenkins_enforcer_rules.BanObsoleteDependencyOverrides passed')
// Should NOT contain property violations
assert !log.contains('Found obsolete property overrides')
return true
