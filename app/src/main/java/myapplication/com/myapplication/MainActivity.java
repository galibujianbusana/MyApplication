package myapplication.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: 二叉树遍历");
        Tree tree=new Tree();
        tree.insert(50,22);
        tree.insert(75,23);
        tree.insert(62,24);
        tree.insert(87,25);
        tree.insert(93,26);
        tree.insert(77,27);
        tree.insert(79,28);



        Node right=tree.root.rightChild;

       Log.d(TAG, "onCreate: 二叉树遍历right"+right.data);

      tree.disPlayTree(tree.root);
       boolean del= tree.deldte(75);

        Log.d(TAG, "onCreate: **************************************************************"+del);
        tree.disPlayTree(tree.root);
        Log.d(TAG, "onCreate: 二叉树遍历的root.rightChild::"+tree.root.rightChild.data);



    }

}
