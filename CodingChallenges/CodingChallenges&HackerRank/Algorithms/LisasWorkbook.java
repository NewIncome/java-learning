import java.util.List;

/**
 * 
 * • Input
 *  ♦ int n: the number of chapters
 *  ♦ int k: the maximum number of problems per page
 *  ♦ int arr[n]: the number of problems in each chapter
 */
/*
  Pseudocode
  //A problem is special if page# == problem#
  //each page can hold up to 'k' problems
  //tProblems % k, will give us the remaining problems in the last page
  //tProblems / k, (Double)  gives the # of pages
  //...how to compare the problemVSpage ?
      //comparing the currentProb to >=, and the currentProb+k <=
  //Approach#1, loop through arr and for each chapter, compare each page's problems for the special-prob
  //vars int pages = 0, problems = 0;
  //Approach#2, mathematical, ...
        
  // another approach
  - issue, how to decide between many pages, when it's a special problem
    it's special when page# == problem #

  page      1       2
  problem [i-ik] [ik-2i+k]
          if  i*k >= page# >= i  == special-problem
  - how to count the pages?
      increment page count together with problems
      - increment page:  page depending on the problem incremente
          problems increments:  i + k,  while problems <= arr[i]
      - on every problems and page increment check for specialProblem
      - on page increment reset problems
  - break on end of chapters, or do greater loop through chapters
 */
public class LisasWorkbook {

  public static int workbook(int n, int k, List<Integer> arr) {
      int inc = 0, pages = 0, problems, specials = 0;
          
      System.out.println("k: " + k);
      for(int probPerCh : arr) {
          problems = 0;
          while(problems <= probPerCh) {
              //increments problems
              // decide the problem-increment, if it's the last problems. Could use inc = problems+k > probPerCh ? (probPerCh-problems) : k;
              if(problems+k > probPerCh)
                  inc = probPerCh - problems;
              else
                  inc = k;
              
              //increment problems and pages
              problems += inc;
              pages += 1;
              
              //check for special page
              //  5    >=    (10 - 5)    &&  5    <=   10
              if(pages >= (problems-inc) && pages <= problems)
                  specials += 1;
              System.out.println("probPerCh: " + probPerCh +
                                  ", pages: " + pages +
                                  ", inc: " + inc +
                                  ", problems: " + problems +
                                  ", specials: " + specials);
                  
              //when in last page, to not add another page
              if(problems == probPerCh) break;
          }
      }
      
      return specials;
  }

}

// Failing TestCase
/*  k: 5
probPerCh:  3, inc: 3, problems:  3, pages:  1, specials: 1  +[1,2,3]
probPerCh:  8, inc: 5, problems:  5, pages:  2, specials: 2  +[1,2,3,4,5]
probPerCh:  8, inc: 3, problems:  8, pages:  3, specials: 2   [6,7,8]
probPerCh: 15, inc: 5, problems:  5, pages:  4, specials: 3  +[1,2,3,4,5]
probPerCh: 15, inc: 5, problems: 10, pages:  5, specials: 4   [6,7,8,9,10] <---- - - - -
probPerCh: 15, inc: 5, problems: 15, pages:  6, specials: 4   [11,12,13,14,15]
probPerCh: 11, inc: 5, problems:  5, pages:  7, specials: 4
probPerCh: 11, inc: 5, problems: 10, pages:  8, specials: 5
probPerCh: 11, inc: 1, problems: 11, pages:  9, specials: 5
probPerCh: 14, inc: 5, problems:  5, pages: 10, specials: 5
probPerCh: 14, inc: 5, problems: 10, pages: 11, specials: 5
probPerCh: 14, inc: 4, problems: 14, pages: 12, specials: 6
probPerCh:  1, inc: 1, problems:  1, pages: 13, specials: 6
probPerCh:  9, inc: 5, problems:  5, pages: 14, specials: 6
probPerCh:  9, inc: 4, problems:  9, pages: 15, specials: 6
probPerCh:  2, inc: 2, problems:  2, pages: 16, specials: 6
probPerCh: 24, inc: 5, problems:  5, pages: 17, specials: 6
probPerCh: 24, inc: 5, problems: 10, pages: 18, specials: 6
probPerCh: 24, inc: 5, problems: 15, pages: 19, specials: 6
probPerCh: 24, inc: 5, problems: 20, pages: 20, specials: 7
probPerCh: 24, inc: 4, problems: 24, pages: 21, specials: 8
probPerCh: 31, inc: 5, problems:  5, pages: 22, specials: 8
probPerCh: 31, inc: 5, problems: 10, pages: 23, specials: 8
probPerCh: 31, inc: 5, problems: 15, pages: 24, specials: 8
probPerCh: 31, inc: 5, problems: 20, pages: 25, specials: 8
probPerCh: 31, inc: 5, problems: 25, pages: 26, specials: 8
probPerCh: 31, inc: 5, problems: 30, pages: 27, specials: 9   [26,27,28,29,30]
probPerCh: 31, inc: 1, problems: 31, pages: 28, specials: 9
  correctOutput: 8, mine: 9
 */
