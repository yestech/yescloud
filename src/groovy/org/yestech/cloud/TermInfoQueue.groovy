package org.yestech.cloud

import org.yestech.cloud.TermInfo
import org.apache.lucene.util.PriorityQueue;

/*
 *
 * Author:  Artie Copeland
 * Last Modified Date: $DateTime: $
 */

public class TermInfoQueue extends PriorityQueue {

  TermInfoQueue(int size) {
    initialize(size);
  }

  protected final boolean lessThan(Object a, Object b) {
    TermInfo termInfoA = (TermInfo) a;
    TermInfo termInfoB = (TermInfo) b;
    return termInfoA.docFreq < termInfoB.docFreq;
  }

}