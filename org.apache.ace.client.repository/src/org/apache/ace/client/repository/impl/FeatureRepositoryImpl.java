/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.ace.client.repository.impl;

import java.util.Map;

import org.apache.ace.client.repository.object.FeatureObject;
import org.apache.ace.client.repository.repository.FeatureRepository;
import org.apache.ace.client.repository.repository.RepositoryConfiguration;

import com.thoughtworks.xstream.io.HierarchicalStreamReader;

/**
 * Implementation class for the FeatureRepository. For 'what it does', see FeatureRepository,
 * for 'how it works', see ObjectRepositoryImpl.
 */
public class FeatureRepositoryImpl extends ObjectRepositoryImpl<FeatureObjectImpl, FeatureObject> implements FeatureRepository {
    private final static String XML_NODE = "features";

    public FeatureRepositoryImpl(ChangeNotifier notifier, RepositoryConfiguration repoConfig) {
        super(notifier, XML_NODE, repoConfig);
    }

    @Override
    FeatureObjectImpl createNewInhabitant(Map<String, String> attributes, Map<String, String> tags) {
        return new FeatureObjectImpl(attributes, tags, this);
    }

    @Override
    FeatureObjectImpl createNewInhabitant(HierarchicalStreamReader reader) {
        return new FeatureObjectImpl(reader, this);
    }
}
