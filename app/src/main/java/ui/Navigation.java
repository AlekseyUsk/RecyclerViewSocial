package ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hfad.recyclerviewsocial.R;

/** патерн Navigation - нужен для того что-бы все манипуляции с фрагментами
вынести в какое то конкретное место
*/
public class Navigation {

    private FragmentManager fragmentManager;

    public Navigation(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public  void replaceFragment(Fragment fragment,boolean useBackStack){
// открыть транзакцию
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        if (useBackStack){
            fragmentTransaction.addToBackStack(null);
        }
//закрытие транзакции
        fragmentTransaction.commit();
    }

    public  void addFragment(Fragment fragment,boolean useBackStack){
// открыть транзакцию
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,fragment);
        if (useBackStack){
            fragmentTransaction.addToBackStack("");
        }
//закрытие транзакции
        fragmentTransaction.commit();
    }

}
