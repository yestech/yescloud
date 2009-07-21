package org.yestech.cloud

import org.apache.lucene.index.Term

/*
 * hold the contents of the cloud terms.
 * 
 * Author:  Artie Copeland
 * Last Modified Date: $DateTime: $
 */

public class TermInfo {

  TermInfo(Term t, double df) {
    term = t;
    docFreq = df;
  }

  public double docFreq;
  public Term term;
}