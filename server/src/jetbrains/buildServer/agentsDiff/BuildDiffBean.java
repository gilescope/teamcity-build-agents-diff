/*
 * Copyright 2000-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jetbrains.buildServer.agentsDiff;

import jetbrains.buildServer.serverSide.BuildAgentEx;
import jetbrains.buildServer.serverSide.SBuild;

import java.util.Collection;
import java.util.Collections;

/**
 * @author Evgeniy.Koshkin
 */
public class BuildDiffBean {
  private final SBuild myBuildA;
  private final SBuild myBuildB;
  private final Collection<BuildAgentsDiffEntry> myEntries;

  public BuildDiffBean(SBuild buildA, SBuild buildB, Collection<BuildAgentsDiffEntry> entries) {
    myBuildA = buildA;
    myBuildB = buildB;
    myEntries = entries;
  }

  public Collection<BuildAgentsDiffEntry> getEntries(){
    return myEntries;
  }

  public String getBuildIdA() {
    return myBuildA.getBuildNumber();
  }

  public String getBuildIdB() {
    if (myBuildB == null)
      return null;
    return myBuildB.getBuildNumber();
  }

  public String getBuildTypeA() {
    return myBuildA.getBuildTypeExternalId();
  }

  public String getBuildTypeB() {
    return myBuildB.getBuildTypeExternalId();
  }

  public static BuildDiffBean empty() {
    return new BuildDiffBean(null, null, Collections.EMPTY_LIST);
  }
}
