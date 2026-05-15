Jenkins-specific or Jenkins-oriented Enforcer rules complementing those available in https://github.com/apache/maven-enforcer and https://github.com/mojohaus/extra-enforcer-rules.

# Running ITs

```bash
mvn -Prun-its verify -Dinvoker.test=bom-obsolete-override-fail-single
```

Running ITs using these rules in `../plugin-pom` is more challenging.
Using `999999-SNAPSHOT` versions of `jenkins-enforcer-rules` does not work apparently because of some problem with `mrm-maven-plugin` and `maven-enforcer-plugin` and Plexus.
Prepare `../plugin-pom` temporarily with:

[source,diff]
----
--- pom.xml
+++ pom.xml
-    <jenkins-enforcer-rules.version>nnnn.vcurrent</jenkins-enforcer-rules.version>
+    <jenkins-enforcer-rules.version>xxx</jenkins-enforcer-rules.version> <!-- TODO revert before commit -->
----

Now run ITs like this:

[source,bash]
----
mvnd -Pquick-build install -Dchangelist=xxx
mvn -f ../plugin-pom clean verify -Dinvoker.test=bom-obsolete-override-*
----

Clean up before commit by switching to an Incremental version of `jenkins-enforcer-rules`:
it _does_ work to specify Incremental versions of `jenkins-enforcer-rules` pull request commits while the `consume-incrementals` placeholder is active, just not snapshot versions;
and to be safe also

[source,bash]
----
rm -rfv ~/.m2/repository/io/jenkins/tools/maven/jenkins-enforcer-rules/xxx
----
