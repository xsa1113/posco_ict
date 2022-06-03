export const getUserById = async (users, id) => {
  const findUserById = await users.find((user) => user.id === id);
  return findUserById;
};

export const getUserByUserId = async (users, userId) => {
  const findUserByUserId = await users.find((user) => user.userId === userId);
  return findUserByUserId;
};

export const postUser = async (users, user) => {
  const newUser = { ...user, userId: user.id, id: users.length };
  return [...users, newUser];
};
export const loginApi = async (users, user) => {
  const checkUser = await users.find((data) => data.userId === user.id && data.password === user.password);
  return { isLogin: checkUser ? true : false, user: checkUser };
};

export const checkId = async (users, userId) => {
  const isCheckId = (await users.find((user) => user.userId === userId)) ? true : false;
  return isCheckId;
};

export const logoutApi = async (userId) => {
  return true;
};

export const getUserByKey = async (users, key) => {
  const findUserByUserId = await users.find((user) => key.test(user.name));
  return findUserByUserId;
};

export const putUsers = async (users, user, id) => {
  const findUsresIndex = await users.findIndex((user) => user.id === id);
  const { name, img } = user;
  if (findUsresIndex === -1) {
    console.error("not found");
    return;
  }
  const newUsers = [...users];
  newUsers.splice(findUsresIndex, 1, { ...users[findUsresIndex], name, img });
  return newUsers;
};
