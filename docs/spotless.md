# Spotless Linting Setup

This project uses Spotless for code formatting. Spotless is configured
to work with Kotlin, Groovy, Gradle KTS files, and XML files.

## Features

The Spotless configuration includes:

- Kotlin formatting using [ktlint](https://github.com/pinterest/ktlint)
- Customizable formatting using `ktlint` and the `.editorconfig` file
- [Custom Compose UI rules](https://github.com/mrmans0n/compose-rules?ref=nlopez.io) for better
  Jetpack Compose code formatting
- Gradle and XML file formatting

## Using Spotless

### IntelliJ/Android Studio Run Configurations

The project includes pre-configured run configurations in the `.run` directory:

1. **Spotless Check**: Verifies if all files conform to the formatting rules
	- Run using: `./gradlew spotlessCheck`
	- Or use the "Spotless Check" run configuration in Android Studio

2. **Spotless Apply**: Automatically formats all files according to the rules
	- Run using: `./gradlew spotlessApply`
	- Or use the "Spotless Apply" run configuration in Android Studio

> [!TIP]
> Always run Spotless Apply before committing your changes to ensure consistent code formatting.

### CI/CD Integration

The project's GitHub Actions workflow automatically runs `spotlessCheck` on pull requests. Your PR
will fail if there are any formatting issues.

## Configuration Details

The Spotless configuration is defined in `gradle/init.gradle.kts` and includes:

### Kotlin Configuration

```kotlin
kotlin {
    target("**/*.kt")
    targetExclude("**/build/**/*.kt")
    // FIXME: This no longer working after spotless updata
    // ktlint(ktlintVersion).userData(mapOf("android" to "true"))
    // Temp Fix
    ktlint(ktlintVersion)
}
```

### Other File Types

The configuration includes similar setups for:

- Groovy (Gradle) files
- Kotlin Script (`.kts`) files
- XML files

> [!IMPORTANT]
> The build task will fail if any files don't match the formatting rules. Always run `spotlessApply`
> if `spotlessCheck` fails.

## Best Practices

1. **Pre-commit Hook**: Consider setting up a pre-commit hook to run `spotlessApply`:
	```bash
	./gradlew spotlessApply
	```

2. **IDE Integration**: Use the provided run configurations in Android Studio for easy access to
   Spotless commands.

3. **Regular Checks**: Run Spotless Check periodically during development, not just before commits.

> [!TIP]
> If you're using Android Studio, you can bind the Spotless Apply run configuration to a keyboard
> shortcut for quick formatting.

## Further Reading
- [Useful Tips & Tricks](tips.md): Get useful tips for development and debugging
- [CI/CD Setup](github.md): Set up continuous integration and deployment for the project
