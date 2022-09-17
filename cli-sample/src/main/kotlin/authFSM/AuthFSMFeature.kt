package authFSM

import AuthInteractor
import authFSM.actions.AuthFSMAction
import ru.kontur.mobile.visualfsm.*
import ru.kontur.mobile.visualfsm.providers.GeneratedTransitionsFactoryProvider.provideTransitionsFactory

@GenerateTransitionsFactory
class AuthFSMFeature : Feature<AuthFSMState, AuthFSMAction>(
    initialState = AuthFSMState.Login("", ""),
    asyncWorker = AuthFSMAsyncWorker(AuthInteractor()),
    transitionCallbacks = AuthFSMTransitionLogger(),
    transitionsFactory = provideTransitionsFactory(),
)