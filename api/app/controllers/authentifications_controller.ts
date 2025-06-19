import User from '#models/user'
import type { HttpContext } from '@adonisjs/core/http'

export default class AuthentificationsController {
  async login({ request }: HttpContext) {
    const body = request.body()
    const email = String(body.email)
    const password = String(body.password)

    const user = await User.verifyCredentials(email, password)

    if (user) {
      const token = await User.accessTokens.create(user)
      return {
        type: 'bearer',
        token: token.value!.release(),
      }
    }
  }

  async logout({ auth }: HttpContext) {
    const user = await auth.authenticate()
    await User.accessTokens.delete(user, user.currentAccessToken.identifier)
  }
}
