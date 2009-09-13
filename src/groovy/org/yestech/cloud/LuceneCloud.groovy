package org.yestech.cloud

import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
//import org.apache.commons.logging.Log
//import org.apache.commons.logging.LogFactory
//import org.apache.lucene.index.IndexReader
//import org.apache.lucene.index.TermEnum
//import org.apache.lucene.store.Directory
//import org.apache.lucene.store.FSDirectory
import org.yestech.cloud.TermInfo
import org.yestech.cloud.TermInfoQueue

/*
 *
 * Author:  Artie Copeland
 * Last Modified Date: $DateTime: $
 */

public class LuceneCloud {
//  private static final Log LOG = LogFactory.getLog(LuceneCloud.class);

  public boolean option_skip_three = false;
  public boolean option_skip_numbers = false;
  public boolean option_dashes = false;

  public double max = 0;
  public double sum = 0;

  public LuceneCloud() {
  }

  /**
   * Break fields down from comma sep list.
   */
//  private List<String> readIndexFields(String fields) {
//    List<String> indexList = new ArrayList<String>();
//    StringTokenizer st = new StringTokenizer(fields, ",");
//    while (st.hasMoreTokens()) {
//      //get next token and store it in the array
//      indexList.add(st.nextToken());
//    }
//    return indexList;
//  }

  /**
   * Used to read the script file into a string.
   */
//  public String readFile(String filename) throws IOException {
//    StringBuffer buffer = new StringBuffer();
//    BufferedReader bufRdr = new BufferedReader(new FileReader(new File(filename)));
//    String line = null;
//    //read each line of text file
//    while ((line = bufRdr.readLine()) != null) {
//      buffer.append(line);
//      buffer.append("\r\n");
//    }
//    bufRdr.close();
//
//    return buffer.toString();
//  }

  /**
   * Junk file is a comma sep list of junk terms and deonminators.
   * These terms will be broken down into a list and used to reject items within a cloud.
   * Following options are supported, and must be specified on a individual line
   *    -numbers - ignore numbers
   *    -smallwords - skips words with three or less chars
   *    -dashes - ignore terms with dashes
   *    # - lines startinig with # are ignored.
   */
//  private List<String> readJunkFile(String filename) throws IOException {
//
//    List<String> junkList = new ArrayList<String>();
//    BufferedReader bufRdr = new BufferedReader(new FileReader(new File(filename)));
//    String line = null;
//
//    //read each line of text file
//    while ((line = bufRdr.readLine()) != null) {
//      if (line.startsWith("#") || line.trim().length() == 0) {
//        continue;
//      } else if (line.startsWith("-numbers")) {
//        option_skip_numbers = true;
//        continue;
//      } else if (line.startsWith("-smallwords")) {
//        option_skip_three = true;
//        continue;
//      } else if (line.startsWith("-dashes")) {
//        option_dashes = true;
//        continue;
//      }
//      StringTokenizer st = new StringTokenizer(line, ",");
//      while (st.hasMoreTokens()) {
//        //get next token and store it in the array
//        junkList.add(st.nextToken());
//      }
//    }
//
//    bufRdr.close();
//    return junkList;
//  }

  /**
   * Utility function for isNumber on each and every char, think there is a function somewhere in java for this.
   */
//  private boolean isNumber(final String s) {
//    for (char c: s.toCharArray()) {
//      if (!Character.isDigit(c)) {
//        return false;
//      }
//    }
//    return true;
//  }

  /**
   * Get the list of terms to be used in the cloud, the list is randomized before returned.
   * @param dir index directory
   * @param junkWords list of junkwords to ignore while building the list
   * @param numTerms top N terms to return
   * @param indexFields list of index fields to use to build cloud
   * @return ranomzed list of top N terms.
   */
//  public List<TermInfo> getCloud(Directory dir, List<String> junkWords, int numTerms, List<String> indexFields) throws Exception {
//    if (dir == null || indexFields == null) {
//      return null;
//    }
//
//    TermInfoQueue tiq = new TermInfoQueue(numTerms);
//    IndexReader reader = IndexReader.open(dir);
//    TermEnum terms = reader.terms();
//
//    double minFreq = 0;
//    while (terms.next()) {
//      String field = terms.term().field();
//      String text = terms.term().text();
//      if (indexFields != null & !indexFields.contains(field)) {
//        continue;
//      }
//      if (junkWords != null && junkWords.contains(text)) {
//        continue;
//      }
//      if (option_skip_three && text.length() <= 3) {
//        continue;
//      }
//      if (option_skip_numbers && isNumber(text)) {
//        continue;
//      }
//      if (option_dashes && text.indexOf("-") > 0) {
//        continue;
//      }
//      if (terms.docFreq() > minFreq) {
//        if (tiq.size() >= numTerms) {
//          // if tiq overfull {
//          tiq.pop();                 // remove lowest in tiq
//        }
//        tiq.put(new TermInfo(terms.term(), terms.docFreq()));
//        minFreq = ((TermInfo) tiq.top()).docFreq; // reset minFreq
//      } else {
//        tiq.put(new TermInfo(terms.term(), terms.docFreq()));
//      }
//    }
//
//    terms.close();
//    reader.close();
//
//    ArrayList<TermInfo> res = new ArrayList<TermInfo>(tiq.size());
//    while (tiq.size() > 0) {
//      TermInfo ti = (TermInfo) tiq.pop();
//      max = Math.max(max, ti.docFreq);
//      sum += ti.docFreq;
//      res.add(ti);
//    }
//
//    // Shuffles the results up, since a sorted cloud would be predictiable.
//    Collections.shuffle(res);
//
//    return res;
//  }

  /**
   * Determine the level which should be assigned to this percentage,
   * this could be written based on some more options.
   */
//  public int getClassFromPercent(double percent) {
//    int _class;
//    if (percent >= 99)
//      _class = 1;
//    else if (percent >= 70)
//      _class = 2;
//    else if (percent >= 60)
//        _class = 3;
//      else if (percent >= 50)
//          _class = 4;
//        else if (percent >= 40)
//            _class = 5;
//          else if (percent >= 30)
//              _class = 6;
//            else if (percent >= 20)
//                _class = 7;
//              else if (percent >= 10)
//                  _class = 8;
//                else if (percent >= 5)
//                    _class = 9;
//                  else
//                    _class = 0;
//
//    return _class;
//  }

  /**
   * Usage: java ...cloud -crawl [crawl] -junk [junkfile] -count [count] -field [field] -template [file].
   * crawl - the directory to the crawl base directory.  It expects the {crawl}/indexes/part-00000/ to be within.
   * count - number of items within the cloud.
   * field - comma sep list of fields to use for clouid (site, content, anchors, ...)
   * template - template file to be invoked (javascript) afterwards to generate content about the cloud.
   */
//  public static void main(String[] args) throws Exception {
//
//    if (args.length == 0) {
//      System.out.println("Usage: org.apache.nutch.generator.tagcloud.cloud -crawl [crawl] - junk [junkfile] -count [count] -field [field] -template [file]");
//      System.exit(0);
//    }
//
//    int count = 0;
//    String crawl = null;
//    String fields = null;
//    String templateFile = null;
//    String junk = null;
//    for (int x = 0; x < args.length; x++) {
//      if (args[x].equals("-crawl"))
//        crawl = args[++x];
//      else if (args[x].equals("-count"))
//        count = Integer.parseInt(args[++x]);
//      else if (args[x].equals("-field"))
//          fields = args[++x];
//        else if (args[x].equals("-junk"))
//            junk = args[++x];
//          else if (args[x].equals("-template"))
//              templateFile = args[++x];
//    }
//
//    cloud c = new LuceneCloud();
//    List<TermInfo> terms = c.getCloud(FSDirectory.getDirectory(crawl + "/indexes/part-00000/", false), c.readJunkFile(junk), count, c.readIndexFields(fields));
//
//    String template = null;
//    if (templateFile != null) {
//      template = c.readFile(templateFile);
//    } else {
//      template = "println( ti.docFreq + ',' + ti.term.text() )";
//    }
//
//
//    ScriptEngineManager factory = new ScriptEngineManager();
//    ScriptEngine engine = factory.getEngineByName("JavaScript");
//    engine.put("cloud", c);
//    for (TermInfo ti: terms) {
//      engine.put("ti", ti);
//      engine.eval(template);
//    }
//  }
}
