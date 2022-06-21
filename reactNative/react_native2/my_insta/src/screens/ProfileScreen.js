import { useIsFocused, useLinkTo } from '@react-navigation/native';
import { useEffect } from 'react';
import { Button, Text, View, TouchableOpacity, Image } from 'react-native';
import { useDispatch, useSelector } from 'react-redux';
import { IMG_PATH } from '../http/CustomAxios';
import { selectMyFollower, selectMyFollowing } from '../store/follows';
import { selectMyPost } from '../store/posts';
import PostScreen from './PostScreen';

const ProfileScreen = () => {
   const linkto = useLinkTo();
   const {name, img} = useSelector((state) => state.users.me)
   const myPosts = useSelector((state) => state.posts.myPosts);
   const myFollowing = useSelector((state) => state.follows.myFollowing);
   const myFollower = useSelector((state) => state.follows.myFollower);
   const dispatch = useDispatch();
   const isFocused = useIsFocused();
   useEffect(() => {
      dispatch(selectMyFollower());
      dispatch(selectMyFollowing());
      dispatch(selectMyPost());
   },[isFocused]);
   const out = () => {
      dispatch(logout);

   }

   return(
      <>

    <View>
       <Text>{`name: ${name}`}</Text>
       <View>
          <Button title="+" onPress={() => linkto("/PostAdd")}></Button>
          <Button title="logout" onPress={out}></Button>
       </View>
       <Text>{`img: ${img}`}</Text>
   </View>
   <View>
      <TouchableOpacity onPress={() => linkto("/UserUpdate")}>
         <Image source = {{uri:`${IMG_PATH}${img}`}} style={{width: 30, height:30}}></Image>
      </TouchableOpacity>
   </View>
   <View>
      <View>
         <Text>게시글</Text>
         <Text>{myPosts.posts.length}</Text>
      </View>
   </View>
   <View>
      <View>
         <Text>팔로워</Text>
         <Text>{myFollower.follows.length}</Text>
      </View>
   </View>
   <View>
      <View>
         <Text>팔로잉</Text>
         <Text>{myFollowing.follows.length}</Text>
      </View>
      <PostScreen>post ={myPosts.posts}</PostScreen>
   </View>
   </>
   )
};
export default ProfileScreen;

// 스타일 주기