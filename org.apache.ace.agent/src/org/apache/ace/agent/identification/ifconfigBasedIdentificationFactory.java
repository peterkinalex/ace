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
package org.apache.ace.agent.identification;

import java.util.Map;

import org.apache.ace.agent.spi.OneComponentFactoryBase;
import org.apache.ace.identification.Identification;
import org.apache.felix.dm.Component;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogService;

/**
 * Component factory for a {@link Identification} service with a {@link IfconfigIdentification} implementation.
 * 
 */
public class ifconfigBasedIdentificationFactory extends OneComponentFactoryBase {

    @Override
    public Component createComponent(BundleContext context, DependencyManager manager, LogService logService, Map<String, String> configuration) {

        Identification impl = new IfconfigIdentification();
        return manager.createComponent()
            .setInterface(Identification.class.getName(), getAgentproperties(configuration)).setImplementation(impl);
    }
}