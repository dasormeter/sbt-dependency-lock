/*
 * Copyright 2019 Michael Stringer
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

package software.purpledragon.sbt.lock.model

import java.time.Instant
import java.util.Objects

final case class DependencyLockFile(
    lockVersion: Int,
    timestamp: Instant,
    configurations: Seq[String],
    dependencies: Seq[ResolvedDependency]) {

  override def hashCode(): Int = Objects.hash(int2Integer(lockVersion), configurations, dependencies)

  override def equals(obj: Any): Boolean = {
    obj match {
      case other: DependencyLockFile =>
        lockVersion == other.lockVersion && configurations == other.configurations && dependencies == other.dependencies
      case _ =>
        false
    }
  }
}
