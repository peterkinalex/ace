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
package org.apache.ace.test.mockautoconf;

import java.util.Properties;

import org.apache.felix.dependencymanager.DependencyActivatorBase;
import org.apache.felix.dependencymanager.DependencyManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.deploymentadmin.spi.ResourceProcessor;

public class Activator extends DependencyActivatorBase {

    private static final String PID = "org.osgi.deployment.rp.autoconf";

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        MockAutoConf impl = new MockAutoConf();
        Properties props = new Properties();
        props.put(Constants.SERVICE_PID, PID);

        manager.add(createService().setInterface(ResourceProcessor.class.getName(), props)
                .setImplementation(impl));
    }

    @Override
    public void destroy(BundleContext context, DependencyManager manager) throws Exception {
        // do nothing
    }
}
