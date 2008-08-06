/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.group;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Return information about map update
 * 
 */
public class MapRequest {
    private final AtomicBoolean done = new AtomicBoolean();
    private Object response;
    private RequestCallback callback;

    Object get(long timeout) {
        synchronized (this.done) {
            if (this.done.get() == false && this.response == null) {
                try {
                    this.done.wait(timeout);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return this.response;
    }

    void put(String id,Object response) {
        this.response = response;
        cancel();
        RequestCallback callback = this.callback;
        if (callback != null) {
            callback.finished(id);
        }
    }

    void cancel() {
        this.done.set(true);
        synchronized (this.done) {
            this.done.notifyAll();
        }
    }
    
    void setCallback(RequestCallback callback) {
        this.callback=callback;
    }
}
