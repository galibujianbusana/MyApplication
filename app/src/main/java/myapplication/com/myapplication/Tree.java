package myapplication.com.myapplication;

import android.content.Context;
import android.util.Log;

/**
 * Created by Administrator on 2017/3/18.
 */

public class Tree {

    Node root;

    public Tree() {
    }

    /**
     *  删除节点
     * @param key
     */
    public  boolean deldte( int key){
        Node current=root;
        Node parent=root;
        boolean isLeftChild=true;
        /**
         * 先把删除值的Node找出来
         */
        while(current.data!=key){
            parent=current;
            if(key<current.data){
                isLeftChild=true;
                current=current.leftChild;
            }else {
                isLeftChild=false;
                current=current.rightChild;
            }
            if(current==null){
                return  false;
            }

        }         // while结束，查找到删除节点，就是current

        /**
         * 如果删除节点是叶节点
         */

        if(current.leftChild==null&&current.rightChild==null){
            if(current==root){
                root=null;
            }else if(isLeftChild){
                parent.leftChild=null;
            }else{
                parent.rightChild=null;
            }

        }

        /**
         * 如果删除的节点没有rightChild，只有leftChild
         */

        else if(current.rightChild==null){
            if(current==root){
                root=current.leftChild;
            }
            else  if(isLeftChild){
                parent.leftChild=current.leftChild;
            }
            else {
                parent.rightChild=current.leftChild;
            }
        }

        /**
         * 如果删除的节点只有rightChild
         */
        else if(current.leftChild==null){
            if(current==root){
                root=current.rightChild;
            }
            else if(isLeftChild){
                parent.leftChild=current.rightChild;
            }else{
                parent.rightChild=current.rightChild;
            }
        }

        /**
         * 如果删除点有2个节点
         */


        else {

            /**
             * 获取后续节点
             */
            Node successor=getSuccessor(current);
            if(current==root){
                root=successor;
            }else if( isLeftChild){
                parent.leftChild=successor;
            }else{
                parent.rightChild=successor;
            }
            successor.leftChild=current.leftChild;


        }






        return true;
    }

    /**
     *  查找节点
     *
     * @param key 查找的值，在该代码中为Node.data
     */
    public Node find(int key){

        Node current =root;
        while (current.data!=key){
            /**
             * 小于当前节点的值，去left查找，否则去right
             */
            if(key<current.data){
                current=current.leftChild;
            }else {
                current=current.rightChild;
            }
            /**
             * 没查找到
             */
            if(current==null){
                return  null;
            }

        }
        return current;
    }

    /**
     * @param key   插入值 node.data
     * @param otherdata  插入的其他数据  node.otherdata
     */
    public void insert( int key,int otherdata){
        Node newNode=new Node();
        newNode.data=key;
        newNode.otherData=otherdata;
        if(root==null){
            root=newNode;
        }else{
            Node current=root;
            Node parent;
            while (true)
            {
                parent=current;
                if(key<current.data){
                    current=current.leftChild;
                    if(current==null){
                        parent.leftChild=newNode;
                        return;
                    }
                }else{
                    current=current.rightChild;
                    if(current==null){
                        parent.rightChild=newNode;

                        return;
                    }
                }
            }

        }


    }

    /**
     * 递归遍历二叉树(中序)
     */

    public void disPlayTree(Node node){
        if(node!=null){
            if(node.leftChild!=null){
                disPlayTree(node.leftChild);
            }

            Log.d("", "二叉树遍历: "+node.data);
            if(node.rightChild!=null){
                disPlayTree(node.rightChild);
            }

        }
    }
    /**
     * 获取后序节点
     */
    public  Node  getSuccessor(Node delNode){
        Node successorParent =delNode;
        Node successor=delNode;
        Node current=delNode.rightChild;
        while(current!=null){
            successorParent=successor;
            successor=current;
            current=current.leftChild;
        }
        if(successor!=delNode.rightChild){
            successorParent.leftChild=successor.rightChild;
           successor.rightChild=delNode.rightChild;

        }
        Log.d("二叉树遍历", "getSuccessor: "+successor.data);
        return successor;
    }

}
