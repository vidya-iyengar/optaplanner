/*
 * Copyright 2015 JBoss Inc
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

package org.optaplanner.persistence.jpa.impl.score.buildin.simple;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.TypeDef;
import org.junit.Test;
import org.optaplanner.core.api.score.buildin.simple.SimpleScore;
import org.optaplanner.persistence.jpa.impl.score.AbstractScoreHibernateTypeTest;

import static org.junit.Assert.*;

public class SimpleScoreHibernateTypeTest extends AbstractScoreHibernateTypeTest {

    @Test
    public void persistAndMerge() {
        Long id = persistAndAssert(new TestJpaEntity(null));
        findAssertAndChangeScore(TestJpaEntity.class, id, null, SimpleScore.valueOf(-10));
        findAndAssert(TestJpaEntity.class, id, SimpleScore.valueOf(-10));
    }

    @Entity
    @TypeDef(defaultForType = SimpleScore.class, typeClass = SimpleScoreHibernateType.class)
    public static class TestJpaEntity extends AbstractTestJpaEntity<SimpleScore> {

        protected SimpleScore score;

        private TestJpaEntity() {
        }

        public TestJpaEntity(SimpleScore score) {
            this.score = score;
        }

        @Columns(columns = {@Column(name = "score")})
        public SimpleScore getScore() {
            return score;
        }

        public void setScore(SimpleScore score) {
            this.score = score;
        }

    }

}
