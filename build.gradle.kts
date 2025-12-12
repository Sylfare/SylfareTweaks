plugins {
    `java-library`
    alias(libs.plugins.paperweightUserdev)
    alias(libs.plugins.runPaper)
}

group = "re.sylfa.sylfaretweaks"
version = "1.0.0-SNAPSHOT"
description = "Some quality of life tweaks"

java {
    // Configure the java toolchain. This allows gradle to auto-provision JDK 21 on systems that only have JDK 11 installed for example.
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

dependencies {
    paperweight.paperDevBundle(libs.versions.paper)
}

tasks {
    compileJava {
        // Set the release flag. This configures what version bytecode the compiler will emit, as well as what JDK APIs are usable.
        // See https://openjdk.java.net/jeps/247 for more information.
        options.release = 21
    }
    javadoc {
        options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything
    }
}
