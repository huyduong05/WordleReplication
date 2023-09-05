public class WordChecker extends WordBank{ 
    private String answer; 
   
    public WordChecker() { 
        super(); 
        answer = super.getWord(); 
    }
    
    /**
     * @param s
     * sets the answer to String s
     */
    public void setAnswer(String s) { 
        answer = s;
    }

    /**
     * Returns the answer 
     * @return answer
     */
    public String getAnswer() { 
        return answer; 
    
    }

    /**
     * key: 
     * 0 - letter not in the word
     * 1 - letter in the word but at wrong index
     * 2 - letter in word and at the right index
     * 
     * @param s - String getting checked
     * @return 0, 1, or 2
     * */
    public int[] checker(String s) {
        int[] result = new int[5];
        String answer = getAnswer();
    
        int index = 0;
        for (char c : s.toCharArray()) {
            if (c == answer.charAt(index)) {
                result[index] = 2;
            } else if (answer.indexOf(c) > -1) {
                result[index] = 1;
            } else {
                result[index] = 0;
            }
            index++;
        }
    
        return result;
    }
    

    /**
     * @param s - String getting checked
     * @return boolean indicating if s is the correct word
     */
    public boolean rightWord(String s, int i) { 
        int[] check = checker(s); 
        if (check[i] == 2) { 
            if (i >= 4) { 
                return true;
            } else { 
                return rightWord(s, i + 1); 
            }
        } 

        return false;
        
    } 

    /**
     * Checks if word in on wordList
     * @param word
     * @return if the word on the wordList
     */
    public boolean actualWord(String word) { 
        word = word.toLowerCase();
        int l = 0, r = getWordList().size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            int res = word.compareTo(getWord(m));
 
            if (res == 0)
                return true;
 
            if (res > 0)
                l = m + 1;
 
            else
                r = m - 1;
        }
 
        return false;
    }
 
}