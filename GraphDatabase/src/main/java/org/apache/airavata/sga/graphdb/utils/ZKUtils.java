/*
 *
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
 *
*/
package org.apache.airavata.sga.graphdb.utils;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.ZKPaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by goshenoy on 3/21/17.
 */
public class ZKUtils {

    private static final Logger logger = LoggerFactory.getLogger(ZKUtils.class);
    private static CuratorFramework curatorClient;

    /**
     *  Get curatorFramework instance
     * @return
     */
    public static final CuratorFramework getCuratorClient() {
        if (curatorClient == null) {
            synchronized (ZKUtils.class) {
                if (curatorClient == null) {
                    String connectionSting = Constants.ZOOKEEPER_SERVER;
                    RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 5);
                    curatorClient = CuratorFrameworkFactory.newClient(connectionSting, retryPolicy);
                }
            }
        }
        return curatorClient;
    }


    public static void createExpZKNode(final CuratorFramework curatorClient, final String expId) throws Exception {

        // construct ZK paths for exp
        String zkPath = ZKPaths.makePath(Constants.RUNNING_EXP_DIR, expId);

        // construct byte-data(s) for exp
        byte[] zkData = zkPath.getBytes();

        logger.debug("Creating Zk node for experiment: " + expId);
        ZKPaths.mkdirs(curatorClient.getZookeeperClient().getZooKeeper(), zkPath);

        // set zkNode data for exp
        curatorClient.setData().withVersion(-1 ).forPath(zkPath, zkData);
    }


    public static final List<String> getExpZKNodes(final CuratorFramework curatorClient) throws Exception {

        String zkPath = ZKPaths.makePath(Constants.RUNNING_EXP_DIR, "");
        // get list of experiments
        List<String> experimentIds = curatorClient.getChildren().forPath(zkPath);

        return experimentIds;
    }

    public static final String deleteZKNode(final CuratorFramework curatorClient, final String expId)throws Exception{
        // construct ZK paths for exp
        String zkPath = ZKPaths.makePath(Constants.RUNNING_EXP_DIR, expId);

        logger.debug("Deleting Zk node for experiment: " + expId);
        curatorClient.getZookeeperClient().getZooKeeper().delete(zkPath, curatorClient.getZookeeperClient().getZooKeeper().exists(zkPath,true).getVersion());

        return zkPath;
    }

    public static void main(String[] args) {
        String connectionString = "localhost:2181";
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 5);

        CuratorFramework curatorClient = CuratorFrameworkFactory.newClient(connectionString, retryPolicy);
        curatorClient.start();
        try {
            //ZKUtils.createExpZKNode(curatorClient, "testExpId");
            System.out.println(ZKUtils.getExpZKNodes(curatorClient));
            ZKUtils.deleteZKNode(curatorClient, "testExpId");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
