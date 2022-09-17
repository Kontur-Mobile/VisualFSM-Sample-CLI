package authFSM

import AuthInteractor
import authFSM.actions.AuthFSMAction
import ru.kontur.mobile.visualfsm.Action
import ru.kontur.mobile.visualfsm.GenerateTransitionsFactory
import ru.kontur.mobile.visualfsm.Transition
import ru.kontur.mobile.visualfsm.TransitionCallbacks
import ru.kontur.mobile.visualfsm.providers.GeneratedTransitionsFactoryProvider.provideTransitionsFactory
import ru.kontur.mobile.visualfsm.rxjava3.FeatureRx

@GenerateTransitionsFactory
class AuthFSMFeature : FeatureRx<AuthFSMState, AuthFSMAction>(
    initialState = AuthFSMState.Login("", ""),
    asyncWorker = AuthFSMAsyncWorker(AuthInteractor()),
    transitionCallbacks = AuthFSMTransitionLogger(),
    transitionsFactory = provideTransitionsFactory(),
)