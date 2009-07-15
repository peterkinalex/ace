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
package org.apache.ace.client.services;

import java.io.Serializable;

/**
 * Value object for communicating target status between the server and the client.
 */
public class TargetDescriptor implements Serializable {
    /**
     * Generated serialVersionUID
     */
    private static final long serialVersionUID = 5952880998043058158L;

    /**
     * The provisioning state; we cannot reuse the server's one here.
     */
    public enum ProvisioningState {
        FAILED,
        IDLE,
        INPROGRESS,
        OK
    }
    
    private String m_name;
    private ProvisioningState m_provisioningState;
    
    public TargetDescriptor() {}

    public TargetDescriptor(String name, ProvisioningState provisioningState) {
        m_name = name;
        m_provisioningState = provisioningState;
    }

    public String getName() {
        return m_name;
    }

    public ProvisioningState getProvisioningState() {
        return m_provisioningState;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(getClass())) {
            return m_name.equals(((TargetDescriptor) obj).m_name);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return m_name.hashCode();
    }

}