/*
 * Copyright 2014 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaplanner.benchmark.impl.statistic;

import org.optaplanner.benchmark.config.statistic.ProblemStatisticType;
import org.optaplanner.benchmark.impl.result.SubSingleBenchmarkResult;

public abstract class ProblemBasedSubSingleStatistic<P extends StatisticPoint> extends SubSingleStatistic<P> {

    protected final ProblemStatisticType problemStatisticType;

    protected ProblemBasedSubSingleStatistic(SubSingleBenchmarkResult subSingleBenchmarkResult,
            ProblemStatisticType problemStatisticType) {
        super(subSingleBenchmarkResult);
        this.problemStatisticType = problemStatisticType;
    }

    @Override
    public ProblemStatisticType getStatisticType() {
        return problemStatisticType;
    }

    @Override
    public String toString() {
        return subSingleBenchmarkResult + "_" + problemStatisticType;
    }

}
