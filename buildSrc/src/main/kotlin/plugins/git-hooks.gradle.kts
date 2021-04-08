/*
 * Copyright 2019 vmadalin.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package plugins

import org.gradle.api.tasks.Copy
import org.gradle.kotlin.dsl.register
import java.io.File


tasks.register<Copy>("installGitHook") {
    File(rootProject.rootDir, ".git/hooks/prepare-commit-msg").apply {
        if (exists())
            delete()
    }
    from(File(rootProject.rootDir, "scripts/git-hooks/prepare-commit-msg"))
    into(File(rootProject.rootDir, ".git/hooks"))
    fileMode = 0x777
}

tasks.getByPath(":app:preBuild").dependsOn(":installGitHook")
