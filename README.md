Jenkins-specific or Jenkins-oriented Enforcer rules complementing those available in https://github.com/apache/maven-enforcer and https://github.com/mojohaus/extra-enforcer-rules.

# Running ITs

```bash
mvn verify -Dinvoker.test=bom-obsolete-override-fail-single
```

Running ITs using these rules in `../plugin-pom` is more challenging.
Prepare `../plugin-pom` temporarily with:

```diff
--- pom.xml
+++ pom.xml
-    <jenkins-enforcer-rules.version>nnnn.vcurrent</jenkins-enforcer-rules.version>
+    <jenkins-enforcer-rules.version>999999-SNAPSHOT</jenkins-enforcer-rules.version> <!-- TODO revert before commit -->
```

(Passing `-Djenkins-enforcer-rules.version=999999-SNAPSHOT` does _not_ suffice.)

Now run ITs like this:

```bash
mvnd -Pquick-build install
mvn -f ../plugin-pom clean verify -Dinvoker.test=bom-obsolete-override-*
```
