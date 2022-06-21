
import AsyncStorage from "@react-native-async-storage/async-storage";
import { createStackNavigator } from "@react-navigation/stack";
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import BottomTabScreen from "./BottomTabScreen";

import LoginNavigate from "./LoginNavigate";

const IndexNavigate = () => {
    const isLogin = useSelector((state) => state.users.isLogin);

    const dispatch = useDispatch();
    const reLogin = async() => {
        const user = await AsyncStorage.getItem("user");
        dispatch(login(JSON.parse(user)));
    }
    useEffect(() => {
        reLogin();
    },[]);
    const Stack = createStackNavigator();
    return isLogin? (
        <Stack.Navigator>
                <Stack.Screen name="home" component={<BottomTabScreen></BottomTabScreen>  }
                options = {{
                    headerShown:false
                }}
                ></Stack.Screen>
                <Stack.Screen name="PostAdd" component={<BottomTabScreen></BottomTabScreen> }
                options = {{
                    headerTitle:"글쓰기",
                }}
                ></Stack.Screen>
                
        
            
        </Stack.Navigator>
        ) : (<LoginNavigate></LoginNavigate>
        );
};
export default IndexNavigate;