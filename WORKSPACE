load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "4.1"
RULES_JVM_EXTERNAL_SHA = "f36441aa876c4f6427bfb2d1f2d723b48e9d930b62662bf723ddfb8fc80f0140"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")
maven_install(
    artifacts = [
        "org.apache.thrift:libthrift:0.17.0",
        "org.slf4j:slf4j-api:2.0.3",
        "javax.annotation:javax.annotation-api:1.3.2",
        "ch.qos.logback:logback-classic:1.4.4"
    ],
    repositories = [
        "https://repo.maven.apache.org/maven2/",
        "https://maven.google.com",
    ],
)