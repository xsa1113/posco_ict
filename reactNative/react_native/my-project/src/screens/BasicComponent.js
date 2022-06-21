import { StyleSheet } from "react-native";
import { View } from "react-native";
import { Image, Text } from "react-native";
import { TextInput } from "react-native";
import { ScrollView } from "react-native";
import { useState } from "react/cjs/react.development";

const BasicComponent = (props) => {
    const [name, setName] = useState("");
    return(
        <ScrollView>
        <View>
        <Image 
        style = {styles.img} 
        source ={{uri:"https://search.pstatic.net/common/?src=http%3A%2F%2Fimgnews.naver.net%2Fimage%2F5630%2F2021%2F06%2F14%2F0000030659_001_20210614181617866.jpg&type=a340"}}>

        </Image>
        <Image 
        style = {styles.img} 
        source ={{uri:"https://search.pstatic.net/common/?src=http%3A%2F%2Fimgnews.naver.net%2Fimage%2F5630%2F2021%2F06%2F14%2F0000030659_001_20210614181617866.jpg&type=a340"}}>

        </Image>
        <Text>hello world</Text>
        <TextInput style={styles.input} onChangeText={(e) => setName(e)}></TextInput>
        <Text>{name}</Text>
        <Text>{props.title}</Text>
    </View>

    </ScrollView>

    )
}

export default BasicComponent;

const styles =  StyleSheet.create({
    img:{
        width: 1000,
        height: 1000
    },
    input: {
        borderBottomColor:"green",
        borderWidth:1,
        width:100,
        height:50,
        padding:5,
    },

})