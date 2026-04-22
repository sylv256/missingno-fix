# Missingno Fix
Missingno Fix fixes missing textures in 26.1, 26.1.1, 26.1.2, and 26.1.x.

In 26.1.x, missing block textures appear with a broken texture due to an atlas mismatch where the item atlas is used instead of the block atlas. This mod fixes that so all blocks with broken textures use the black and magenta texture you're familiar with.

## Maven
```kts
repositories {
    exclusiveContent {
        forRepository {
            maven {
                name = "Sylv"
                url = uri("https://maven.sylv.gay/releases/")
            }
        }

        filter {
            includeGroup("gay.sylv.missingno")
        }
    }

}

dependencies {
    runtimeOnly("gay.sylv.missingno:missingno-fix:1.0.0")
}
```
