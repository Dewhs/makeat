/*
|--------------------------------------------------------------------------
| Routes file
|--------------------------------------------------------------------------
|
| The routes file is used for defining the HTTP routes.
|
*/

import router from '@adonisjs/core/services/router'

const UsersController = () => import('#controllers/users_controller')
const AuthentificationsController = () => import('#controllers/authentifications_controller')


router.post('/users', [UsersController, 'create'])

router.get('/users/me', [UsersController, 'getMyFullName'])

router.get('/users', [UsersController, 'index'])

router.post('/login', [AuthentificationsController, 'login'])

router.post('/logout', [AuthentificationsController, 'logout'])


