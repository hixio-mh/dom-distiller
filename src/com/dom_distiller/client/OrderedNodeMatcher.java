// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package com.dom_distiller.client;

import java.util.List;
import java.util.Iterator;

import com.google.gwt.dom.client.Node;

/**
 * Used to match a list of nodes in order.
 */
public class OrderedNodeMatcher {
    private final Iterator<Node> nodeIter;
    private Node nextNode;

    public OrderedNodeMatcher(List<Node> nodes) {
        this.nodeIter = nodes.iterator();
        if (!nodes.isEmpty()) {
            nextNode = this.nodeIter.next();
        }
    }

    /**
     * @return Whether the node matches the next one in the list. If true, the expected next node
     * will be advanced.
     */
    public boolean match(Node n) {
        if (!n.equals(nextNode)) return false;

        nextNode = nodeIter.hasNext() ? nodeIter.next() : null;
        return true;
    }

    /**
     * @return Whether there are any nodes left to match in the list.
     */
    public boolean isFinished() {
        return nextNode == null;
    }
}
