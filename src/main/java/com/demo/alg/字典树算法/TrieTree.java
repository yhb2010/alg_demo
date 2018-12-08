package com.demo.alg.字典树算法;

public class TrieTree {

	Node root;

	public TrieTree(String name) {
		root = new Node(name);
		root.setFre(0);
		root.setEnd(false);
		root.setRoot(true);
	}

	/**对于插入单词操作。因为单词的长度是已知的，所以，这里我们就可以以单词长度作为限制进行循环。在插入单词的过程中，如果某一个字母已经存在，则将遍历的位置移至此节点，如果发现某一个字母不存在，则新建一个，再移动遍历节点。
	 * @param word
	 */
	public void insert(String word) {
		Node node = root;
		char[] words = word.toCharArray();
		for (int i = 0; i < words.length; i++) {
			if (node.getChildrens().containsKey(words[i] + "")) {
				if (i == words.length - 1) {
					Node endNode = node.getChildrens().get(words[i] + "");
					endNode.setFre(endNode.getFre() + 1);
					endNode.setEnd(true);
				}
			} else {
				Node newNode = new Node(words[i] + "");
				if (i == words.length - 1) {
					newNode.setFre(1);
					newNode.setEnd(true);
					newNode.setRoot(false);
				}

				node.getChildrens().put(words[i] + "", newNode);
			}

			node = node.getChildrens().get(words[i] + "");
		}
	}

	/**对于查找，相对于插入代码量要小一些。这是因为在查找的过程中，如果找到了就继续直到单词结尾，如果没找到就返回
	 * @param word
	 * @return
	 */
	public int searchFre(String word) {
		int fre = -1;

		Node node = root;
		char[] words = word.toCharArray();
		for (int i = 0; i < words.length; i++) {
			if (node.getChildrens().containsKey(words[i] + "")) {
				node = node.getChildrens().get(words[i] + "");
				fre = node.getFre();
			} else {
				fre = -1;
				break;
			}
		}

		return fre;
	}

	public String splitSpell(String spell) {
        Node node = root;
        char[] letters = spell.toCharArray();
        String spells = "";
        boolean b = true; //是否需要执行i--
        for (int i = 0; i < letters.length; i++) {
            if (node.getChildrens().containsKey(letters[i] + "")) {
                spells += letters[i];
                node = node.getChildrens().get(letters[i] + "");
                b = true;
            } else {
                if(b){
                	node = root;
                	spells += " ";
                	i--;
                }
                b = false;
            }
        }

        return spells;
    }

}
