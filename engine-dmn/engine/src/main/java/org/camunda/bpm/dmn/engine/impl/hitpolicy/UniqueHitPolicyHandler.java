/* Licensed under the Apache License, Version 2.0 (the "License");
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

package org.camunda.bpm.dmn.engine.impl.hitpolicy;

import java.util.List;

import org.camunda.bpm.dmn.engine.DmnDecisionTable;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.dmn.engine.DmnDecisionTableRule;
import org.camunda.bpm.dmn.engine.hitpolicy.DmnHitPolicyHandler;
import org.camunda.bpm.dmn.engine.impl.DmnLogger;

public class UniqueHitPolicyHandler implements DmnHitPolicyHandler {

  public static final DmnHitPolicyLogger LOG = DmnLogger.HIT_POLICY_LOGGER;

  public DmnDecisionTableResult apply(DmnDecisionTable decisionTable, DmnDecisionTableResult decisionTableResult) {
    List<DmnDecisionTableRule> matchingRules = decisionTableResult.getMatchingRules();

    if (matchingRules.size() < 2) {
      return decisionTableResult;
    }
    else {
      throw LOG.uniqueHitPolicyOnlyAllowsSingleMatchingRule(matchingRules);
    }
  }

}
